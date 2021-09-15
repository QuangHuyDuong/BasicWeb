function login() {
    var user_name = document.querySelector(".username").value
    var password = document.querySelector(".password").value
    var user_info = {
    username : user_name,
    password : password
}

    fetch("http://localhost:8080/Web/LoginController", {
        method: 'POST', 
        body: JSON.stringify(user_info), 
        headers:{
          'Content-Type': 'application/json'
        }
      })
      .then(res => res.json())
      .then(response => {
		console.log(response)
		if(response.responseStr == "Dang nhap that bai"){
			 location.replace("http://localhost:8080/Web/login.html");
			 alert("Sai ten tai khoan hoac mat khau")
		} else {
			 location.replace("http://localhost:8080/Web/Home.html");
		}
		
})
}