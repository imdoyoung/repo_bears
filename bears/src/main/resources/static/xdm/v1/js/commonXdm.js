// LogoutProc
document.getElementById("SignoutBtn").onclick = function() {
	alert("로그아웃 성공");
	$.ajax({
		async: true
		, cache: false
		, type: "post"
		/* ,dataType:"json" */
		, url: "/xdm/v1/infra/user/userXdmSignoutProc"
		/* ,data : $("#formLogin").serialize() */
		, success: function(response) {
			if (response.rt == "success") {
				location.href = "/xdm/v1/infra/user/userXdmSignin";
			} else {
				// by pass
			}
		}
	});
}
