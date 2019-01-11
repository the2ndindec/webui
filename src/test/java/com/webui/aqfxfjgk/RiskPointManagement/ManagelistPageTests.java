package com.webui.aqfxfjgk.RiskPointManagement;

import com.webui.action.aqfxfjgk.RiskPointManagement.ManagelistPageActions;
import com.webui.utils.TestBaseCase;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @Description:
 * @Data 2019/01/11 15:03
 */
public class ManagelistPageTests extends TestBaseCase {

    ManagelistPageActions mlpa = new ManagelistPageActions();
    @Test
    public void TC() throws IOException {

      mlpa.motifyMenu();
      mlpa.clicl(1005,300);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
