let text = ``;
files.forEach(file => {
    text += `<img src="/files/display?fileName=${file.filePath}/${file.fileUuid}_${file.fileName}" width="200px" class="file-list">`;
});
$("#thumbnail-list").append(text);
