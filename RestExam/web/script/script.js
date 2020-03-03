var printedIDs = [];
var localLastId = 0;

function submit(messageContent) {
    var message = {};
    message.content = messageContent;
    var request = new XMLHttpRequest();
    request.open("POST", "http://192.168.23.194:8080/RestExam_war_exploded/rest/messages", false);
    request.setRequestHeader("Content-type", "application/json");
    request.setRequestHeader("Accept", "application/json");
    request.send(JSON.stringify(message));
    var response = JSON.parse(request.responseText);
    console.log(response);
}

function readInput(ev) {
    if (ev.keyCode === 13) {
        submit(ev.target.textContent);
        ev.target.textContent = "";
        ev.preventDefault();
    }
}

function log(content) {
    document.getElementById("log").textContent += content + "\n";
}

function poll() {
    setInterval(fetch, 2000);
}

function fetch() {
    var request = new XMLHttpRequest();
    request.open("GET", "http://192.168.23.194:8080/RestExam_war_exploded/rest/messages", false);
    request.setRequestHeader("Accept", "application/json");
    // request.setRequestHeader("lastId", printedIDs.length.toString());
    request.setRequestHeader("lastId", localLastId);
    request.send();
    var messages = JSON.parse(request.responseText);
    var i;
    for (i = 0; i < messages.length; i++) {
        // control(messages[i]);
        log(messages[i].content);
        localLastId = messages[i].id;
    }
}

function control(message) {
    if (!printedIDs.includes(message.id)) {
        log(message.content);
        printedIDs.push(message.id);
    }
}



    