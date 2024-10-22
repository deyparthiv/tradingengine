package ted;

import java.util.List;

public class TradeEngineServerCore {
    public static class TradingEngineServiceProvider{
        public static List<IServiceProvider> ServiceProvider;

        public static void create(){
        }
        public List<IServiceProvider> get(){return ServiceProvider;}
        public void set(List<IServiceProvider>tedsp){ServiceProvider=tedsp;}
    }
}
