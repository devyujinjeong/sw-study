// 인스턴스 생성 과정
// 1. 빈 객체 생성
// 2. this에 생성된 객체 바인딩
// 3. 프로토타입 연결
// 4. 완성된 this를 자동으로 반환
function Student(name, age) {
    // 1. new 연산자와 함께 호출 될 경우 암묵적으로 인스턴스가 생성 되며
    // this에 바인딩 되는 과정이 런타임 이전에 실행
    console.log(this);
    // 2. this에 바인딩 되어 있는 인스턴스에 프로퍼티를 추가한다.
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }
    // 3. 완성 된 인스턴스가 바인딩 된 this가 암묵적으로 반환 된다.
    // return {}; -> 명시적으로 객체를 반환하면 암묵적인 this 반환이 무시 된다.
    // return 1; -> 명시적으로 원시 값을 반환하면 return 구문이 무시 되고 this가 반환 된다.
}

const student = new Student('장보고', 35);
console.log(student);
console.log(student.getInfo());