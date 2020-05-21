package cuit.Group9.LDM.util.Handler;

        import cuit.Group9.LDM.util.AdminQuery;

        import java.util.Date;
        import java.text.DateFormat;
        import java.util.stream.Stream;

//进行字符串处理
public class SqlHandler {
    //插入用语句
    final private String insert = "insert into ";
    final private String values = " values ";
    //查询用语句
    final private String select = "select ";
    final private String from = " from ";
    final private String where = " where ";
    final private String all = " * ";
    final private String nums = " COUNT(*) ";
    final private String end = ";";
    final private String between = " between ";
    final private String and = " and ";
    final private String date = " date ";
    final private String limit = " limit ";
    //final private String selectAll = select + "*" + from;
    //final private String countAll = select + "COUNT(*)" + from;
    //更新用语句
    final private String update = " update ";
    final private String set = " set ";

    //登陆状态验证
    public String selectUser(String[] col, String[] colna,
                             String[] valna, String table) {
        return select + Splice(col) + from + table +
                where + Splice(colna, valna) + end;
    }

    public String insert(String[] cols,String[] vals,String table) {
        return insert + table + "(" + Splice(cols) + ")" +
                values + "(" + SpliceVals(vals) + ")" + end;
    }

    //批量插入
    public String insertMulty(String[] cols, String[] vals,
                              String table) {
        return insert + table +
                " (" + Splice(cols) + ") " +
                values +
                SpliceM(vals) +
                end;
    }

    //整表查询
    public String selectAll(String table) {
        return select + all + from + table + end;
    }

    public String selectAll(String col,String val,String table) {
        return select + all + from + table + where +
                col + "= '" + val + "'" + end;
    }

    //单一条件多结果查询
    public String selectMulty(String col, String val,
                              String table) {
        return select + all + from + table + where +
                col + " = '" + val + "'" + end;
    }

    //指定数量查询
    public String select_limited(String[] cols,String[] vals, String table,int num) {
        return select + all + from + table + where +
                Splice(cols, vals) +
                limit + num + end;
    }

    public String select_limited(String col, String val,String[] boolcols,String[] boolvals, String table,int num) {
        return select + all + from + table + where + col + "='" + val + "'" + and +
                Splice_bool(boolcols, boolvals) +
                limit + num + end;
    }

    //固定条件查询
    public String selectBy(String col, String val,
                           String colname, String valname,
                           String table) {
        return select + all + from + table +
                where + col + " = '" + val + "'" + and +
                colname + "= '" + valname + "'" + end;
    }

    //固定条件查询-boolean
    public String selectByBool(String col, String val,
                           String colname, String valname,
                           String table) {
        return select + all + from + table +
                where + col + " = " + val + and +
                colname + "= '" + valname + "'" + end;
    }

    //多列查询
    public String selectMulty(String[] col,
                            String[] val,
                            String table) {
        return select + Splice(col) + from + table +
                where + Splice(col, val) + end;
    }
    //多列含bool值
    public String selectMulty(String[] col, String[] val,
                              String boolcol, String boolval,
                              String table) {
        return select + all + from + table +
                where + Splice(col, val) +
                and + boolcol + "=" + boolval + end;
    }

    //按照日期区间进行查询
    public String selectByDate(String begin,
                               String end,
                               String dateCol,
                               String table) {
        return select + all + from + table + where +
                dateCol + between + "'" + begin + "'" + and +
                "'" + end + "'" + this.end;
    }


    //统计所有条目
    public String countAll(String table) {
        return select + nums + from + table + end;
    }

    //统计表中的指定项
    public String count(String col, String val,
                        String table) {
        return select + nums + from + table + where +
                col + "= '" + val + "' " + end;
    }

    //统计指定状态项
    public String count(String[] col, String[] val,
                        String table) {
        return select + nums + from + table +
                where + Splice(col, val) + end;
    }

    public String count(String col, boolean val,
                        String table) {
        return select + nums + from + table + where +
                col + "= '" + val + "' " + end;
    }

    //单条查询
    public String select(String data, String col,
                         String table) {
        return select + col + from + table + where +
                col + " = '" + data + "' " + end;
    }


    //更新单列数据
    public String update(String col, String val,
                         String concol, String conval,
                         String table) {
        return update + table + set +
                col + "= '" + val + "' " + where +
                concol + "= '" + conval + "'" + end;
    }

    //更新多列数据
    public String update(String[] cToUp, String[] vForUp,
                         String concol, String conval,
                         String table) {
        return update + table + set +
                Spliceins(cToUp, vForUp) + where +
                concol + "= '" + conval + "'" + end;
    }

    public String update(String[] cToUp, String[] vForUp,
                         String[] concol, String[] conval,
                         String table) {
        return update + table + set +
                Spliceins(cToUp, vForUp) + where +
                Splice(concol, conval) + end;
    }

    //进行指定条数的更新
    public String update_Limited(String[] cToUp, String[] vForUp,
                                 String[] concol, String[] conval,
                                 int num, String table) {
        return update + table + set + Splice(cToUp, vForUp) +
                where + Splice(concol, conval) +
                limit + num +
                end;
    }

    //进行sql语句的拼接
    public String Splice(String[] strings) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i != strings.length - 1)
                res.append(strings[i]).append(",");
            else
                res.append(strings[i]);
        }
        return res.toString();
    }

    //进行sql语句的拼接
    public String SpliceM(String[] strings) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i != strings.length - 1)
                res.append("(").append(strings[i]).append("),");
            else
                res.append("(").append(strings[i]).append(")");
        }
        return res.toString();
    }

    public String SpliceMauty(String[] vals) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            if (i != vals.length - 1) {
                res.append(" '").append(vals[i]).append("', ");
            } else {
                res.append(" '").append(vals[i]).append("'");
            }
        }
        return res.toString();
    }

    public String SpliceVals(String[] vals) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            if (i != vals.length - 1) {
                if (vals[i].equals("false") || vals[i].equals("true")
                        || vals[i].equals("0")) {
                    res.append(vals[i]).append(",");
                } else {
                    res.append(" '").append(vals[i]).append("', ");
                }
            } else {
                if (vals[i].equals("false") || vals[i].equals("true")
                        || vals[i].equals("0")) {
                    res.append(vals[i]);
                } else {
                    res.append(" '").append(vals[i]).append("'");
                }
            }
        }
        return res.toString();
    }

    public String Splice(String[] cols, String[] vals) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i != cols.length - 1) {
                if (vals[i].equals("true") || vals[i].equals("false")) {
                    res.append(cols[i]).append(" = ").
                            append(vals[i]).append(" and ");
                }else{
                    res.append(cols[i]).append(" = '").
                            append(vals[i]).append("' and ");

                }
            } else {
                if (vals[i].equals("true") || vals[i].equals("false")) {
                    res.append(cols[i]).append(" = ").
                            append(vals[i]);
                }else{
                    res.append(cols[i]).append(" = '").
                            append(vals[i]).append("' ");

                }
            }
        }
        return res.toString();
    }

    public String Splice_bool(String[] cols, String[] vals) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i != cols.length - 1)
                res.append(cols[i]).append(" = ").
                        append(vals[i]).append(" and ");
            else
                res.append(cols[i]).append(" = ").
                        append(vals[i]);
        }
        return res.toString();
    }

    public String Spliceins(String[] cols, String[] vals) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i != cols.length - 1) {
                if (vals[i].equals("true") || vals[i].equals("false")) {
                    res.
                            append(cols[i]).append(" = ").
                            append(vals[i]).append(", ");

                } else {
                    res.
                            append(cols[i]).append(" = '").
                            append(vals[i]).append("', ");
                }
            } else {
                if (vals[i].equals("true") || vals[i].equals("false")) {
                    res.
                            append(cols[i]).append(" = ").
                            append(vals[i]);

                } else {
                    res.
                            append(cols[i]).append(" = '").
                            append(vals[i]).append("'");
                }
            }
        }
        return res.toString();
    }


    //public String Splice(String str1) {
    //
    //    return str1;
    //}

    //获取当前日期为字符串格式
    public String setDate() {
        Date now = new Date();
        DateFormat strD = DateFormat.getDateInstance();
        return strD.format(now);
    }

}
