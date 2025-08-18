var persons = [
    { name: "pavan", age: 30, city: "andhra pradesh" },
    { name: "kiran", age: 17, city: "mumbai" },
    { name: "chakri", age: 22, city: "bangalore" },
    { name: "mohana", age: 15, city: "chennai" }
];

var eligibleVoters = persons.filter(function(person) {
    return person.age >= 18;
});
var voterNames = eligibleVoters.map(function(voter) {
    return voter.name;
});
console.log(voterNames);