function addToCart(id, name){
	var product = {
		id : id,
		name : name
	}
	fetch('http://localhost:8080/Web/client/addToCart',{
		method : "POST",
		body : JSON.stringify(product),
		headers: {
		'Content-type': 'application/json; charset=UTF-8'
	}
	})
	.then(response => response.json())
	.then(result => {
		if(result.responseStr == "Chua dang nhap") {
			alert("Ban can dang nhap")
		} else if (result.responseStr =="Them thanh cong"){
			alert("Da them vao gio hang")
		}
		
	})

	
}