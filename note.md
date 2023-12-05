đa hình : ghi đè, nạp chồng ;
String currentDate = new SimpleDateFormat("dd-MM-yyyy-h:m:s").format(new java.util.Date());
BillManagement billManagement = new BillManagement(Constant.dataPath.Bills_Dir, currentDate);
