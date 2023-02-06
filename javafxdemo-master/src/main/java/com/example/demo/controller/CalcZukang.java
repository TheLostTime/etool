package com.example.demo.controller;

import lombok.Data;
import lombok.experimental.Accessors;

public class CalcZukang {

    public static void main(String[] args) {
        // testDhlDdx();
       // testDhl2Fl();
        testShl2Fl();
    }

    /**
     * 验证单回路单导线
     */
    public static void testDhlDdx() {
        // 初始化输入对象
        ZkParam zkParam = new ZkParam();
        zkParam.setAlx(-5.1).setAly(13.00).setBlx(-5.7).setBly(0.0).setClx(-6.2).setCly(6.3).setGlx(-6.2).setGly(17.5)
                .setArx(6.2).setAry(6.3).setBrx(5.7).setBry(0.0).setCrx(5.1).setCry(13.0).setGrx(6.2).setGry(17.5)
                .setR(0.07389)
                .setN(1.0)
                .setHl("单回路")
                .setDxxh("LGJ-400/35")
                .setFljj(0.4);
        calcZxzk(zkParam);
    }

    /**
     * 验证单回路2分裂导线
     */
    public static void testDhl2Fl(){
        // 初始化输入对象
        ZkParam zkParam = new ZkParam();
        zkParam.setAlx(-5.1).setAly(13.00).setBlx(-5.7).setBly(0.0).setClx(-6.2).setCly(6.3).setGlx(-6.2).setGly(17.5)
                .setArx(6.2).setAry(6.3).setBrx(5.7).setBry(0.0).setCrx(5.1).setCry(13.0).setGrx(6.2).setGry(17.5)
                .setR(0.07389)
                .setN(2.0)
                .setHl("单回路")
                .setDxxh("LGJ-400/35")
                .setFljj(0.4);
        calcZxzk(zkParam);
    }

    /**
     * 验证双回路2分裂导线
     */
    public static void testShl2Fl(){
        // 初始化输入对象
        ZkParam zkParam = new ZkParam();
        zkParam.setAlx(-5.1).setAly(13.00).setBlx(-5.7).setBly(0.0).setClx(-6.2).setCly(6.3).setGlx(-6.2).setGly(17.5)
                .setArx(6.2).setAry(6.3).setBrx(5.7).setBry(0.0).setCrx(5.1).setCry(13.0).setGrx(6.2).setGry(17.5)
                .setR(0.07389)
                .setN(2.0)
                .setHl("双回路")
                .setDxxh("LGJ-400/35")
                .setFljj(0.4);
        calcZxzk(zkParam);
    }

    public static ZkParam reverseDot(ZkParam zkParam) {

        return null;
    }


    public static String calcZxzk(ZkParam zkParam) {
        Double R = calcR (zkParam.getR(),zkParam.getN());
        Double X1 = calcX1(zkParam);
        String Z1 = R + "+j" + X1;
        System.out.println("Z1:" + Z1);
        return Z1;
    }

    public static Double calcX1(ZkParam zkParam) {
        Double dm = calcDm(zkParam);
        Double Re = calcRe(zkParam);
        Double f = 50.0;
        Double X1;
        // TODO 双回路的X1 * 2（分裂数？）
        // Double X1 = 0.0029 * f * (Math.log(dm / Re) / Math.log(10));
        if (zkParam.getHl().equals("单回路")) {
            X1 = 0.0029 * f * (Math.log(dm / Re) / Math.log(10));
        } else {
            X1 = 0.0029 * f * (Math.log(dm / Re) / Math.log(10)) * zkParam.getN();
        }
        System.out.println("正序电抗X1:" + X1);
        return X1;
    }


    /**
     * 导线有效半径
     * @param zkParam
     * @return
     */
    private static Double calcRe(ZkParam zkParam) {
        double Re = 0.0;
        if ("单回路".equals(zkParam.getHl())) {
            if ("LGJ-400/35".equals(zkParam.getDxxh())) {
                double r = 26.82 / 2000; // 半径
                double rel = 0.81 * r;
                Double S = zkParam.getFljj();
                // 导线分裂数
                if (zkParam.getN() == 1.0) {
                    Re = rel;
                } else if (zkParam.getN() == 2.0) {
                    Re = Math.pow((rel * S),(1.0/2));
                } else if (zkParam.getN() == 3.0) {
                    Re = Math.pow((rel * Math.pow(S,2)),(1.0/3));
                } else if (zkParam.getN() == 4.0) {
                    Re = 1.091 * Math.pow((rel * Math.pow(S,3)),(1.0/4));
                } else if (zkParam.getN() == 6.0) {
                    Re = 1.349 * Math.pow((rel * Math.pow(S,5)),(1.0/6));
                } else if (zkParam.getN() == 8.0) {
                    Re = 1.639 * Math.pow((rel * Math.pow(S,7)),(1.0/8));
                }
            }
        } else {
            double r = 26.82 / 2000; // 半径
            Double S = zkParam.getFljj();
            double rel = 0.81 * r;
            // double rel = 0.81 * r; vb版本 或 pdf版本
            //double rel = Math.pow(0.81 * r * S,0.5); // excel版本
            // TODO 需要确认re是否是重新计算结果
            if (zkParam.getN() == 1.0) {
            } else if (zkParam.getN() == 2.0) {
                rel = Math.pow((rel * S),(1.0/2));
            } else if (zkParam.getN() == 3.0) {
                rel = Math.pow((rel * Math.pow(S,2)),(1.0/3));
            } else if (zkParam.getN() == 4.0) {
                rel = 1.091 * Math.pow((rel * Math.pow(S,3)),(1.0/4));
            } else if (zkParam.getN() == 6.0) {
                rel = 1.349 * Math.pow((rel * Math.pow(S,5)),(1.0/6));
            } else if (zkParam.getN() == 8.0) {
                rel = 1.639 * Math.pow((rel * Math.pow(S,7)),(1.0/8));
            }
            Double Daa1 = calcLength(zkParam.getAlx(),zkParam.getAly(),zkParam.getArx(),zkParam.getAry());
            System.out.println("Daa1:" + Daa1);
            Double Dbb1 = calcLength(zkParam.getBlx(),zkParam.getBly(),zkParam.getBrx(),zkParam.getBry());
            System.out.println("Dbb1:" + Dbb1);
            Double Dcc1 = calcLength(zkParam.getClx(),zkParam.getCly(),zkParam.getCrx(),zkParam.getCry());
            System.out.println("Dcc1:" + Dcc1);
            Re = Math.pow((Math.pow(rel,3) * Daa1 * Dbb1 * Dcc1),(1.0/6));
        }
        System.out.println("有效半径Re:" + Re);
        return Re;
    }


    /**
     * 导线几何间距
     * @param zkParam
     * @return
     */
    private static Double calcDm(ZkParam zkParam) {
        Double dm = 0.0;
        if ("单回路".equals(zkParam.getHl())) {
            Double Dab = calcLength(zkParam.getAlx(),zkParam.getAly(),zkParam.getBlx(),zkParam.getBly());
            Double Dbc = calcLength(zkParam.getBlx(),zkParam.getBly(),zkParam.getClx(),zkParam.getCly());
            Double Dca = calcLength(zkParam.getClx(),zkParam.getCly(),zkParam.getAlx(),zkParam.getAly());
            dm = Math.pow((Dab * Dbc * Dca),(1.0/3));
        } else {
            Double Dab = calcLength(zkParam.getAlx(),zkParam.getAly(),zkParam.getBlx(),zkParam.getBly());
            Double Dac = calcLength(zkParam.getAlx(),zkParam.getAly(),zkParam.getClx(),zkParam.getCly());
            Double Dab1 = calcLength(zkParam.getAlx(),zkParam.getAly(),zkParam.getBrx(),zkParam.getBry());
            Double Dac1 = calcLength(zkParam.getAlx(),zkParam.getAly(),zkParam.getCrx(),zkParam.getCry());

            Double Dbc = calcLength(zkParam.getBlx(),zkParam.getBly(),zkParam.getClx(),zkParam.getCly());
            Double Dba = calcLength(zkParam.getBlx(),zkParam.getBly(),zkParam.getAlx(),zkParam.getAly());
            Double Dbc1 = calcLength(zkParam.getBlx(),zkParam.getBly(),zkParam.getCrx(),zkParam.getCry());
            Double Dba1 = calcLength(zkParam.getBlx(),zkParam.getBly(),zkParam.getArx(),zkParam.getAry());


            Double Dca = calcLength(zkParam.getClx(),zkParam.getCly(),zkParam.getAlx(),zkParam.getAly());
            Double Dcb = calcLength(zkParam.getClx(),zkParam.getCly(),zkParam.getBlx(),zkParam.getBly());
            Double Dca1 = calcLength(zkParam.getClx(),zkParam.getCly(),zkParam.getArx(),zkParam.getAry());
            Double Dcb1 = calcLength(zkParam.getClx(),zkParam.getCly(),zkParam.getBrx(),zkParam.getBry());

            dm = Math.pow(Dab * Dac * Dab1 * Dac1 * Dbc * Dba * Dbc1 * Dba1 * Dca * Dcb * Dca1 * Dcb1,(1.0/12));
        }
        System.out.println("dm:" + dm);
        return dm;
    }

    /**
     * 计算相导线电阻
     * @param R 型号对应的直流电阻
     * @param n 导线分裂数
     * @return
     */
    public static Double calcR (Double R, Double n) {
        Double R1 = R / n;
        System.out.println("电阻R:" + R1);
        return R1;
    }

    /**
     * 计算2个点之间的距离
     * @return
     */
    public static Double calcLength(Double Ax , Double Ay,Double Bx, Double By) {
        return Math.sqrt((Math.pow((Ax - Bx),2)) + Math.pow((Ay - By),2));
    }

    @Data
    @Accessors(chain = true)
    static
    class ZkParam {
        // 坐标
        Double Alx;
        Double Aly;
        Double Blx;
        Double Bly;
        Double Clx;
        Double Cly;
        Double Glx;
        Double Gly;

        Double Arx;
        Double Ary;
        Double Brx;
        Double Bry;
        Double Crx;
        Double Cry;
        Double Grx;
        Double Gry;

        // 电阻
        Double R;

        // 分裂数
        Double N;

        // 回路类型
        String hl;

        // 导线型号
        String dxxh;

        // 分裂间距
        Double fljj;
    }

}
