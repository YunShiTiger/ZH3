var webSocket =
      new WebSocket('ws://172.22.140.111:8080/ZH3/websocketS');
 
    webSocket.onerror = function(event) {
      onError(event)
    };
 
    webSocket.onopen = function(event) {
      onOpen(event)
    };
 
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
 
    function onMessage(event) {
      //document.getElementById('tmp').innerHTML = event.data;
    }
 
    function onOpen(event) {
     //alert('connect ok')
    	start();			//����ҳ��������ʱ���Ͳ�ѯ���ָ��
    }
 
    function onError(event) {
      alert(event.data);
    }
 
    function start() {
      webSocket.send('dianbiao');
      return false;
    }
    function sendMessage(dom){
    	var val = dom.getAttribute("value");   //�õ�����¼���value
    	//alert(val);
    	webSocket.send(val);
    }
    function sendMessage_dianbiao(){
    	var val = "dianbiao";
    	//alert(val);
    	webSocket.send(val);
    }