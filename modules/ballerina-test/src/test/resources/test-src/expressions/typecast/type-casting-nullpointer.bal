
//null pointer
function testMapToAnyExplicit() (any) {
    map m = {name:"supun"};
    return (any) m;
}

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
    A c;

    b = (B) a;
    TypeCastError err;
    c, err = (A) b;

    a.x = "updated-x-valueof-a";
    return c, err;
}


function testInCompatibleStructForceCasting()(A, TypeCastError) {
    B b = {x: "x-valueof-b"};
    A a;
    TypeCastError err;
    a, err = (A) b;

    return a, err;
}

function testStructToAnyExplicit() (any) {
    Person p = {name:"Supun",
                   age:25,
                   parent:{name:"Parent", age:50},
                   address:{"city":"Kandy", "country":"SriLanka"},
                   info:{status:"single"},
                   marks:[24, 81]
               };
    return (any)p;
}

//no test case found
function testMapToAny() (any) {
    map m = {};
    return (any) m;
}

//struct to struct is not available
struct Person {
    string name;
    int age;
    map address;
    int[] marks;
    Person parent;
    json info;
    any a;
    float score;
    boolean alive;
}

struct Student {
    string name;
    int age;
    map address;
    int[] marks;
}

function testStructToStruct() (Student) {
    Person p = { name:"Supun",
                   age:25,
                   parent:{name:"Parent", age:50},
                   address:{"city":"Kandy", "country":"SriLanka"},
                   info:{status:"single"},
                   marks:[24, 81]
               };
    return (Student) p;
}

//todo
function testErrorInForceCasting()(A, error) {
    B b = {x: "x-valueof-b"};
    A a;
    TypeCastError castError;
    a, castError = (A) b;

    Error error;
    if (castError != null) {
        error = (error) castError;
    }

    return a, error;
}

//any to struct compilation error
function testAnyToStruct() (Person) {
    any a = { name:"Supun",
                age:25,
                parent:{name:"Parent", age:50},
                address:{"city":"Kandy", "country":"SriLanka"},
                info:{status:"single"},
                marks:[24, 81]
            };
    Person p2;
    TypeCastError e;
    p2, e = (Person) a;
    if (e != null) {
        throw e;
    }
    return p2;
}


function testAnyNullToStruct() (Person) {
    any a;
    Person p;
    p, _ = (Person) a;
    return p;
}
//todo
function testErrorInForceCasting()(A, error) {
    B b = {x: "x-valueof-b"};
    A a;
    TypeCastError castError;
    a, castError = (A) b;

    Error error;
    if (castError != null) {
        error = (error) castError;
    }

    return a, error;
}
