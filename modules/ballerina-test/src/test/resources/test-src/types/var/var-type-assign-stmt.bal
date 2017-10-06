struct Person {
    string name;
    int age;
    Person parent;
    json info;
    map address;
    int[] marks;
    any a;
    float score;
    boolean alive;
}

function testVarDeclarationWithAtLeaseOneNonDeclaredSymbol () (int, TypeConversionError) {
    int a;
    float f = 10.0;
    var a, err = <int>f;
    return a, err;
}


function testIntToVarAssignment() (int) {
    var age = 81;
    return age;
}


function testMultipleIntToVarAssignment() (int,int,int,int) {
    var age, age1, age2, age3 = retFourInt();
    return age, age1, age2, age3;
}

function retFourInt()(int,int,int,int){
    return 100, 200, 300, 400;
}

function testMultipleIntToVarAssignmentWithUnderscore() (int,int) {
    var age, age1, _, _ = retFourInt();
    return age, age1;
}

function testMultipleIntToVarAssignmentWithUnderscoreOrderCaseOne() (int,int) {
    var age, _, age1, _ = retFourInt();
    return age, age1;
}

function testMultipleIntToVarAssignmentWithUnderscoreOrderCaseTwo() (int,int) {
    var age, _, _, age1 = retFourInt();
    return age, age1;
}


