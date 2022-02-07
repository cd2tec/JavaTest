package br.com.sigabem.util;

import java.util.Calendar;
import java.util.Date;

public class dateUtil {

	/**
	 * Calculos das datas
	 * @param campoCalendar
	 * @param quantidade
	 * @param dataParamDt
	 * @return
	 */
	public Date doAddSubData(int campoCalendar, int quantidade, Date dataParamDt) {
        Calendar data = Calendar.getInstance();
        data.setTime(dataParamDt);
        data.add(campoCalendar, quantidade);
        return data.getTime();
    }
}
