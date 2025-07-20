// in 연산자 : 프로퍼티 존재 여부 확인
var student = {
    name : '유관순',
    age : 16,
    test : undefined
};

console.log(student.name === undefined);
console.log(student.age === undefined);
// 프로퍼티는 존재하지만 프로퍼티 값이 undefined 인 상황이라 판별이 모호함
console.log(student.test === undefined);

// 위와 값을 상황을 방지하기 위해서 in을 사용해서 존재하는지 확인한다.
console.log("name" in student);
console.log("age" in student);
// 프로퍼티로서 존재함을 확인할 수 있다.
console.log("test" in student);
console.log("test2" in student);


