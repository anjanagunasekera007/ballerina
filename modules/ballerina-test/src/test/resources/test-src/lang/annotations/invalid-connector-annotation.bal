import lang.annotations.doc;

@doc:Description{value:123}
connector TestConnector (string url) {
    
    @doc:Description{value:"Test action of test connector"}
    action testAction() (boolean) {
        boolean value;
        return value;
    }
}
