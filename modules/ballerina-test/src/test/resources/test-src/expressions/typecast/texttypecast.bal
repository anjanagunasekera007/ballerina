function testJsonIntToString() (string) {
    json j = 5;
    int value;
    value, _ = (int)j;
    return <string> value;
}
