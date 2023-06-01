$(document).ready(function(){
    if(order == 'popular'){
        let $order = $("a.order");
        $("a.order-checked").removeClass("order-checked");
        $order.eq(1).addClass("order-checked");
    }
})

$("a.order").on("click", function(e){
    e.preventDefault();
    let order = this.classList[1];
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    if(this.classList.length == 2){
        $("a.order-checked").removeClass("order-checked");
        $(this).addClass("order-checked");
        location.href = `/post/list?page=${nowPage}&type=${type}&keyword=${keyword}&order=${order}`;
    }
});