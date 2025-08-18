let name="roto"
let str = name.toLowerCase();
let reversed = "";
for (let i = str.length - 1; i >= 0; i--) {
    reversed += str[i];
}
if (str === reversed) {
    console.log("The string is a palindrome.");
} else {
    console.log("The string is not a palindrome.");
}
