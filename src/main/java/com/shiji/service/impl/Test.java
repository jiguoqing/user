package com.shiji.service.impl;

import java.util.Calendar;
import java.util.Date;

public class Test {
  public static void main(String[] args) {
    Date now = new Date();
    Date  myDate = new Date();


    Calendar cale = null;
    cale = Calendar.getInstance();
    int year = cale.get(Calendar.YEAR);
    int y = myDate.getYear();
     cale.set(year,-1,1);

    Date date=cale.getTime();
    Date monthFirst = new Date(myDate.getYear(), 1, 1);
    System.out.println(date);
  }
}
