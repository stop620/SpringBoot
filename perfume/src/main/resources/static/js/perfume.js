function check() {

    console.log("submit");

    // input 객체
    const name = document.querySelector('#input-name');
    const gender = document.querySelector('#select-gender');
    const age = document.querySelector('#input-age');
    const scent = document.querySelector('#select-scent');
    const brand = document.querySelector('#input-brand');

    // 검사
    if (!name.value) {
        alert("이름을 입력하세요.");
        return false;
    }
    if(!gender.value) {
        alert("성별을 선택하세요.")
        return false;
    }
    if(!age.value) {
        alert("올바른 나이를 입력하세요.")
        return false;
    }
    if(!scent.value) {
        alert("좋아하는 향기를 선택하세요.")
        return false;
    }
    if(!brand.value) {
        alert("좋아하는 브랜드를 입력하세요.")
        return false;
    }

    return true;
}