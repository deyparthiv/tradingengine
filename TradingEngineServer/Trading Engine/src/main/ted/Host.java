package ted;

import java.util.List;

public class Host {
    final List<IServiceProvider> services;
    Host(List<IServiceProvider> services){
        this.services=services;
    }

}
