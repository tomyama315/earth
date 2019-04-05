/**
 * @author sksgym(すぎ）
 */

function goLoginAction() {
	document.getElementById("loginForm").action="LoginAction";
}

function goCreateAction() {
	document.getElementById("loginForm").action="CreateUserAction";
}

function goResetPasswordAction() {
	document.getElementById("loginForm").action="ResetPasswordAction";
}