var persons = [
    { name: "pavan", age: 30, city: "andhra pradesh" },
    { name: "kiran", age: 17, city: "mumbai" },
    { name: "chakri", age: 22, city: "bangalore" },
    { name: "mohana", age: 15, city: "chennai" }
];

// for (let i = 0; i < persons.length; i++) {
//     if (persons[i].age >= 18) {
//         persons[i].status = "Adult";
//     } else {
//         persons[i].status = "Minor";
//     }
// }


persons = persons.map(person => {
    if (person.age >= 18) {
        person.status = "Adult";
    } else {
        person.status = "Minor";
    }
    return person;
});


console.log(persons);

