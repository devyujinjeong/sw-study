// null 병합 연산자
// 좌항의 피연산자가 null 또는 undefined인 경우 우항의 피연산자를 반환하고
// 그렇지 않으면 좌항의 피연산자를 반환한다.
// 변수에 기본 값을 설정할 때 유용하다.
var obj = null;
var test = obj ?? '기본값';
console.log(test);

// 단축 평가 활용 시 빈 문자열과 같은 Falsy 값을 false로 취급하는 문제가 있었다.
var val = '' || '기본 값';
console.log(val);
var val2 = '' ?? '기본 값';
console.log(val2);