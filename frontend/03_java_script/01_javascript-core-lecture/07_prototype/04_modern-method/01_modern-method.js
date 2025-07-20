// 프로토타입 접근 시 사용하는 모던 메소드
const user = {
    activate : true
};

// Object.create(proto) : [[Prototype]]이 proto를 참조하는 빈 객체를 만드는 메소드
// user를 프로토타입으로 하는 객체를 생성해주세요!
const student = Object.create(user);
console.log(student.activate);

// Object.getPrototypeOf(obj) : obj의 [[Prototype]] 반환
console.log(Object.getPrototypeOf(student));
console.log(Object.getPrototypeOf(student) === user);
// Object.getPrototypeOf(obj, proto) : obj의 [[Prototype]] 을 proto가 되도록 설정
Object.setPrototypeOf(student, {});
console.log(Object.getPrototypeOf(student));
console.log(Object.getPrototypeOf(student) === user);

// __proto__를 getter, setter로 직접 사용하면 키가 "__proto__" 일 대 에러가 발생하는
// 의도치 않은 상황이 생길 수도 있으므로 메소드 사용을 권장한다.
const obj = Object.create(user);
let key = "__proto__";
console.log(obj[key]);
obj[key] = { test : "새로운 객체 덮어쓰기!" };
console.log(obj[key]);
console.log(obj.__proto__);