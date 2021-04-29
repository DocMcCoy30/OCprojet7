package com.dmc30.clientui.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-api", url = "localhost:9001")
public interface UserApiProxy {
}
