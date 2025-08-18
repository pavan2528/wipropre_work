// Ex 14: Create page with userId and password having a login button and logout button. Store the userId in the localstoarage when login button is clicked and remove it when logout button is clicked.
document.body.innerHTML = `
    <div>
        <label for="userId">User ID:</label>
        <input type="text" id="userId" />
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" />
    </div>
    <button id="loginButton">Login</button>
    <button id="logoutButton">Logout</button>
`;

const loginButton = document.getElementById('loginButton');
const logoutButton = document.getElementById('logoutButton');

loginButton.addEventListener('click', () => {
    const userId = document.getElementById('userId').value;
    if (userId) {
        localStorage.setItem('userId', userId);
        alert('Logged in successfully!');
    } else {
        alert('Please enter a User ID.');
    }
});

logoutButton.addEventListener('click', () => {
    localStorage.removeItem('userId');
    alert('Logged out successfully!');
});