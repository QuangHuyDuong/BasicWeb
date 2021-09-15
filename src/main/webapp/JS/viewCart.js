function viewCart() {
	
    fetch('http://localhost:8080/Web/client/viewCart')
.then(response => response.json())
.then(result => {
    if(result == null){
        alert("Ban can dang nhap")
    } else {
        window.location="http://localhost:8080/Web/Cart.html";
    }
    
})
}