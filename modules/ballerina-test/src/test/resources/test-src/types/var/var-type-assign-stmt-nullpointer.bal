struct A {
    string x;
    int y;
}

struct B {
    string x;
}

function testCompatibleStructForceCasting()(A, TypeCastError) {
    A a = {x: "x-valueof-a", y:4};
    B b = {x: "x-valueof-b"};

    b = (B) a;

    var c, err = (A) b;

    a.x = "updated-x-valueof-a";
    return c, err;
}

function testInCompatibleStructForceCasting()(A, TypeCastError) {
    B b = {x: "x-valueof-b"};

    var a, err = (A) b;

    return a, err;
}

