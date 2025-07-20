// 1. 전달 받은 문자열(str) 안에 있는 값을 ',' 기준으로 배열로 분리하고 전달받은
// 단어(word)가 있는 index 위치를 문자열로 리턴하는 함수 findWord(str, word)를 작성한다.

const str = '사과,바나나,당근,김밥,치즈,떡볶이,햄버거,환타,사이다,콜라,고양이,강아지';

function findWord(str, word) {
    const arr = str.split(',');
    let idx = arr.indexOf(word);
    if (idx > 0) {
        return `${word}는 배열 index ${idx}번째에 있습니다.`
    } else if (word === undefined){
        return '결과를 확인할 수 없습니다.';
    } else {
        return `${word}는 배열에 존재하지 않습니다.`
    }
}

console.log(findWord(str, '고양이'));
console.log(findWord(str, '샌드위치'));
console.log(findWord(str));


// 2. 배열(arr)의 요소 중 a와 b 사이에 속하지 않는 요소는
// 삭제해주는 함수 filterRange(arr, a, b)를 작성한다.
function filterRange(arr, a, b) {
    // a와 b 사이에 속하지 않는 요소를 splice를 통해 제거하기
    // a와 b 사이에 속하지 않는 요소를 찾기
    let max = Math.max(a, b);
    let min = Math.min(a, b);


    for (let i = 0; i < arr.length; i++) {
        if ( min > arr[i] || arr[i] > max){
            arr.splice(i, 1);
        }
    }

    return arr;
}

const arr = [5, 3, 8, 1, 10, 4];
filterRange(arr, 1, 5);
console.log(arr);

// 3. 제시 된 숫자값 배열과 문자값 배열을 오름차순 정렬, 내림차순 정렬하여 출력한다.
let numbers = [20, 100, 37, 54, 88, 9];
let strings = ['wow', 'js', 'party', 'hello'];

console.log(numbers.sort());
console.log(numbers.reverse());
console.log(strings.sort());
console.log(strings.reverse());

// 4. Student 생성자 함수를 통해 생성 된 3명의 학생 객체를 studentList 배열에 담았다.
// 해당 배열을 전달하여 score 내림차순 기준으로 정렬해주는 sortFromScore(arr) 함수,
// 해당 배열을 전달하여 lastName과 firstName을 합성하여
// name 속성으로 만들어 반환하는 makeFullName 함수를 작성한다.
function Student(firstName, lastName, score){
    this.firstName = firstName;
    this.lastName = lastName;
    this.score = score;
}

const studentList = [
    new Student('길동', '홍', 60),
    new Student('보고', '장', 70),
    new Student('관순', '유', 80)
];

function sortFromScore (arr) {
    arr.sort((a, b) => b.score - a.score) ;
}

function makeFullName(arr) {
    name = arr[0] + arr[1];
    const newArr = arr.map(([firstName, lastName, score]) => ({
        name: firstName + ' ' + lastName,
        score: score
    }));

    return newArr;
}

sortFromScore(studentList);
console.log(studentList);
console.log(makeFullName(studentList));
