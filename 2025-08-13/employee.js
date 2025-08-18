let employees = [
    { name: "Alice", role: "Manager", empId: 101, salary: 80000 },
    { name: "Bob", role: "Developer", empId: 102, salary: 60000 },
    { name: "Charlie", role: "QA", empId: 103, salary: 50000 },
    { name: "David", role: "Manager", empId: 104, salary: 85000 },
    { name: "Eve", role: "Developer", empId: 105, salary: 62000 },
    { name: "Frank", role: "Manager", empId: 106, salary: 90000 }
];

let totalManagerSalary = employees
    .filter(emp => emp.role === "Manager")
    .reduce((total, emp) => total + emp.salary, 0);

document.getElementById("result").innerText =
    "Total salary drawn by all Managers: ₹" + totalManagerSalary;
