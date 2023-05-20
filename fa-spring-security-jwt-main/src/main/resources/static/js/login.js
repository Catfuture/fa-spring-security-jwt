if (isLoggedIn()) {
	window.location = '/'
}

const loginButton = document.getElementById('login')
const usernameInput = document.getElementById('username')
const passwordInput = document.getElementById('password')

loginButton.addEventListener('click', async () => {
	let [ok, data, apiErr] = await doFetch(
		() => fetch('/api/users/login', {
			method: 'POST',
			body: JSON.stringify({
				username: usernameInput.value,
				password: passwordInput.value
			}),
			headers: {
				'Content-Type': 'application/json'
			}
		})
	)
	const accessToken = data.accessToken
  if (!ok || !accessToken) {
    handleError(data)
		return
  }

	[ok, data, apiErr] = await doFetch(
		() => fetch('/api/users/current', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json',
				'Authorization': 'Bearer ' + data.accessToken
			}
		})
	)
	const role = data.role
	if (!ok || !role) {
    handleError(data)
		return
  }

	localStorage.setItem('access-token', accessToken)
	localStorage.setItem('role', role)
	window.location = '/'
})
