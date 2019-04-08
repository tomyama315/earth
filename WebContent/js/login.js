/**
 * @author sksgym(すぎ）
 */

function goLoginAction() {
	document.getElementById("loginForm").action="LoginAction";
}

function goCreateUserAction() {
	document.getElementById("loginForm").action="CreateUserAction";
}

function goResetPasswordAction() {
	document.getElementById("loginForm").action="ResetPasswordAction";
}