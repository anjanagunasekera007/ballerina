function floattoint(float value)(int) {
    int result;
    //float to int should be a conversion
    result, _ = <int>value;
    return result;
}

function inttofloat(int value)(float) {
    float result;
    //int to float should be a conversion
    result = <float> value;
    return result;
}

function stringtoint(string value)(int) {
    int result;
    //string to int should be a unsafe conversion
    result, _ = <int>value;
    return result;
}

function stringtofloat(string value)(float) {
    float result;
    //string to float should be a conversion
    result, _ = <float>value;
    return result;
}

function inttostring(int value)(string) {
    string result;
    //int to string should be a conversion
    result = <string>value;
    return result;
}

function floattostring(float value)(string) {
    string result;
    //float to string should be a conversion
    result = <string>value;
    return result;
}

function booleantostring(boolean value)(string) {
    string result;
    //boolean to string should be a conversion
    result = <string>value;
    return result;
}

function booleanappendtostring(boolean value)(string) {
    string result;
    result = value + "-append-" + value;
    return result;
}

function intarrtofloatarr()(float[]) {
    float[] numbers;
    numbers = [999,95,889];
    return numbers;
}

function testJsonToStringCast() (string) {
    json j = "hello";
    string value;
    value, _ = (string)j;
    return value;
}

function testJSONObjectToStringCast() (string, TypeCastError) {
    json j = {"foo":"bar"};
    var value, e = (string)j;
    return value, e;
}

function testJsonToInt() (int){
    json j = 5;
    int value;
    value, _ = (int)j;
    return value;
}

function testJsonToFloat() (float){
    json j = 7.65;
    float value;
    value, _ = (float)j;
    return value;
}

function testJsonToBoolean() (boolean){
    json j = true;
    boolean value;
    value, _ = (boolean)j;
    return value;
}

function testStringToJson(string s) (json) {
    return s;
}

function testAnyNullToMap() (map) {
    any a;
    map value;
    value, _ = (map) a;
    return value;
}

function testAnyNullToXml() (xml) {
    any a;
    xml value;
    value, _ = (xml) a;
    return value;
}

function testAnyToStringWithErrors()(string, TypeCastError) {
    any a = 5;
    string s;
    TypeCastError err;
    s, err = (string) a;

    return s, err;
}

function testAnyToStringWithoutErrors()(string, TypeCastError) {
    any a = "value";
    string s;
    TypeCastError err;
    s, err = (string) a;

    return s, err;
}

function testAnyToIntWithoutErrors()(int, TypeCastError) {
    any a = 6;
    int s;
    TypeCastError err;
    s, err = (int) a;

    return s, err;
}

function testAnyToFloatWithoutErrors()(float, TypeCastError) {
    any a = 6.99;
    float s;
    TypeCastError err;
    s, err = (float) a;

    return s, err;
}

function testAnyToBooleanWithoutErrors()(boolean, TypeCastError) {
    any a = true;
    boolean s;
    TypeCastError err;
    s, err = (boolean) a;

    return s, err;
}

function testAnyNullToStringWithErrors()(string, TypeCastError) {
    any a = null;
    string s;
    TypeCastError err;
    s, err = (string) a;

    return s, err;
}

function testAnyToBooleanWithErrors()(boolean, TypeCastError) {
    any a = 5;
    boolean b;
    TypeCastError err;
    b, err = (boolean) a;

    return b, err;
}

function testAnyNullToBooleanWithErrors()(boolean, TypeCastError) {
    any a = null;
    boolean b;
    TypeCastError err;
    b, err = (boolean) a;

    return b, err;
}

function testAnyToIntWithErrors()(int, TypeCastError) {
    any a = "foo";
    int b;
    TypeCastError err;
    b, err = (int) a;

    return b, err;
}

function testAnyNullToIntWithErrors()(int, TypeCastError) {
    any a = null;
    int b;
    TypeCastError err;
    b, err = (int) a;

    return b, err;
}

function testAnyToFloatWithErrors()(float, TypeCastError) {
    any a = "foo";
    float b;
    TypeCastError err;
    b, err = (float) a;

    return b, err;
}

function testAnyNullToFloatWithErrors()(float, TypeCastError) {
    any a = null;
    float b;
    TypeCastError err;
    b, err = (float) a;

    return b, err;
}


function testAnyToMapWithErrors()(map, TypeCastError) {
    any a = "foo";
    map b;
    TypeCastError err;
    b, err = (map) a;

    return b, err;
}










