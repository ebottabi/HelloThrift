namespace java com.hellothrift.thrift
#@namespace scala com.hellothrift.thrift


struct Response{
    1: required map<string, string> msg;
}

struct UserParam {
    1: required string name;
}

service HelloServices {

  Response sayHelloTo(1: UserParam param)

}