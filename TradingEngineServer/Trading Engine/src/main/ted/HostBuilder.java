package ted;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class HostBuilder {
    List<IServiceProvider> services;
    Logger logger;
    IOptions config;
    HostBuilder(){
        services = new ArrayList<>();
    }
    public void setLogger(Logger logger){
        this.logger = logger;
    }
    public void setConfig(IOptions config){
        this.config = config;
    }
    public void addService(IServiceProvider service){
        if(service!=null) services.add(service);
        else throw new NullPointerException();
    }
    public IHost build() {
        return null;
    }
}
