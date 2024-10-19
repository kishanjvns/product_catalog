package com.example.systeminfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/system-info")
public class SystemInfoController {

    @GetMapping()
    public Map<String, String> getSystemInfo() throws UnknownHostException {
        Map<String, String> systemInfo = new HashMap<>();

        InetAddress localHost = InetAddress.getLocalHost();
        String ipAddress = localHost.getHostAddress();
        String hostName = localHost.getHostName();

        systemInfo.put("IP Address", ipAddress);
        systemInfo.put("Host Name", hostName);
        systemInfo.put("Canonical Host Name", localHost.getCanonicalHostName());
        systemInfo.put("Operating System", System.getProperty("os.name"));
        systemInfo.put("OS Version", System.getProperty("os.version"));
        systemInfo.put("OS Architecture", System.getProperty("os.arch"));
        systemInfo.put("User", System.getProperty("user.name"));

        return systemInfo;
    }
}
