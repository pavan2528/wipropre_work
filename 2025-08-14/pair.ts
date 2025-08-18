function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}

let result1 = pair<number, string>(1, "Hello");
let result2 = pair<boolean, number>(true, 42);

console.log(result1);
console.log(result2);
