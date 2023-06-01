package com.example.controller.controller.task;

import com.example.controller.domain.vo.ProductVO;
import com.example.controller.domain.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@Controller
@Slf4j
@RequestMapping("/task/*")
public class TaskController {
//    [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.
    @GetMapping("product")
    public void goToProductForm(ProductVO productVO){;}

    @PostMapping("product")
    public void write(ProductVO productVO){;}

//    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력
    @GetMapping("student")
    public String goToStudentForm(StudentVO studentVO){
        return "task/student/student";
    }

    @PostMapping("student")
    public String write(StudentVO studentVO){
        return "task/student/result";
    }

//    [실습 3]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html

    @GetMapping("checkIn")
    public String goToCheckInForm(){
        return "/task/checkIn/checkIn";
    }

    @GetMapping("get-to-work")
    public String getToWork(@ModelAttribute("name") String name){
        LocalTime now = LocalTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        boolean lateCondition = hour >= 9 && minute > 0;

        return "/task/checkIn/" + (lateCondition? "late" : "get-to-work");
    }

    @GetMapping("leave-work")
    public String leaveWork(@ModelAttribute("name") String name){
        LocalTime now = LocalTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        boolean leaveWorkCondition = hour >= 17 && minute >= 0;

        return "/task/checkIn/" + (leaveWorkCondition? "leave-work" : "work");
    }
}
