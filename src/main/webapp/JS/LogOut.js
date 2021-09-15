function logout() {
    if(confirm("Ban co muon dang xuat?")){
	fetch('http://localhost:8080/Web/LogOutController')
   .then(response => {
    location.replace("http://localhost:8080/Web/Home.html");
   });
}
}