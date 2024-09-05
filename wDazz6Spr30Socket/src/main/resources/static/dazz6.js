let stompClient = null;

function connect() {
	alert("A");	
	let socket = newSockJs('/ws');
	
	// 클라이언트가 WebSocket 연결을 통해 Stomp를 사용할 수 있도록 설정
	stompClient = Stomp.over(socket);
	
	stompClient.connect({}, function(frame){
		// frame : command, header, body 로 구성
		console.log("connected : " + frame);
		// '/topic/messages' 로 수신된 메시지를 처리
		// 메시지를 수신(구독)한 클라이언트는 서버가 해당 경로에 브로드캐스트한 메시지를 모두 수신 가능
		// 한 명의 클라이언트가 메시지를 전송하면 접속된 모든 클라이언트가 이를 수신할 수 있다
		stompClient.subscribe('/topin/messages', function(message) {
			showMessage(message.body)
			
		})
	})
	
}

function setMessage() {
	let msgContent = document.querySelector("#message").value;	
	stompClient.send('/app/message', {}, msgContent);
}

function showMessage(message) {
	let msgElement = document.createElement("li"); // DOM
	msgElement.textContent = message;
	document.querySelector("#msgArea").appendChild(msgElement);
}

window.onload = function() {

}