import lang.annotations.doc;

@doc:Description{value:"Test connector"}
connector TestConnector (string url) {
    
    @doc:Description{value:654}
    action testAction() (boolean) {
       boolean value;
       return value;
    }
}
