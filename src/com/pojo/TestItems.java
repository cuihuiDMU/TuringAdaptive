package com.pojo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("testItems")
public class TestItems implements Serializable {
	public TestItems(String A,String B,String C,int D,int E,String F,int G,float H,int I,int J,int K,float L,int M,float N,int O,float P,int Q,float R,int S,float T,int U,float V,int W,float X,int Y,float Z,int AA,String AB){
		this.A = A;this.B = B;this.C = C;this.D = D;this.E = E;this.F = F;this.G = G;this.H = H;this.I = I;this.J = J;this.K = K;this.L = L;this.M = M;this.N = N;this.O = O;this.P = P;this.Q = Q;this.R = R;this.S = S;this.T = T;this.U = U;this.V = V;this.W = W;this.X = X;this.Y = Y;this.Z = Z;this.AA = AA;this.AB = AB;
	}
	public TestItems(){
		
	}
	
	private int test_id;
	private String username;
	private String A;
	private String B;
	@Value("")
	private String C;
	@Value("0")
	private int D;
	@Value("0")
	private int E;
	@Value("")
	private String F;
	@Value("0")
	private int G;
	@Value("0.0")
	private float H;
	@Value("0")
	private int I;
	@Value("0")
	private int J;
	@Value("0")
	private int K;
	@Value("0.0")
	private float L;
	@Value("0")
	private int M;
	@Value("0.0")
	private float N;
	@Value("0")
	private int O;
	@Value("0.0")
	private float P;
	@Value("0")
	private int Q;
	@Value("0.0")
	private float R;
	@Value("0")
	private int S;
	@Value("0.0")
	private float T;
	@Value("0")
	private int U;
	@Value("0.0")
	private float V;
	@Value("0")
	private int W;
	@Value("0.0")
	private float X;
	@Value("0")
	private int Y;
	@Value("0.0")
	private float Z;
	@Value("0")
	private int AA;
	@Value("")
	private String AB;
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public int getD() {
		return D;
	}
	public void setD(int d) {
		D = d;
	}
	public int getE() {
		return E;
	}
	public void setE(int e) {
		E = e;
	}
	public String getF() {
		return F;
	}
	public void setF(String f) {
		F = f;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public float getH() {
		return H;
	}
	public void setH(float h) {
		H = h;
	}
	public int getI() {
		return I;
	}
	public void setI(int i) {
		I = i;
	}
	public int getJ() {
		return J;
	}
	public void setJ(int j) {
		J = j;
	}
	public int getK() {
		return K;
	}
	public void setK(int k) {
		K = k;
	}
	public float getL() {
		return L;
	}
	public void setL(float l) {
		L = l;
	}
	public int getM() {
		return M;
	}
	public void setM(int m) {
		M = m;
	}
	public float getN() {
		return N;
	}
	public void setN(float n) {
		N = n;
	}
	public int getO() {
		return O;
	}
	public void setO(int o) {
		O = o;
	}
	public float getP() {
		return P;
	}
	public void setP(float p) {
		P = p;
	}
	public int getQ() {
		return Q;
	}
	public void setQ(int q) {
		Q = q;
	}
	public float getR() {
		return R;
	}
	public void setR(float r) {
		R = r;
	}
	public int getS() {
		return S;
	}
	public void setS(int s) {
		S = s;
	}
	public float getT() {
		return T;
	}
	public void setT(float t) {
		T = t;
	}
	public int getU() {
		return U;
	}
	public void setU(int u) {
		U = u;
	}
	public float getV() {
		return V;
	}
	public void setV(float v) {
		V = v;
	}
	public int getW() {
		return W;
	}
	public void setW(int w) {
		W = w;
	}
	public float getX() {
		return X;
	}
	public void setX(float x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public float getZ() {
		return Z;
	}
	public void setZ(float z) {
		Z = z;
	}
	public int getAA() {
		return AA;
	}
	public void setAA(int aA) {
		AA = aA;
	}
	public String getAB() {
		return AB;
	}
	public void setAB(String aB) {
		AB = aB;
	}
		public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getA() {
		return A;
	}
	public void setA(String A) {
		this.A = A;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getB() {
		return B;
	}
	public void setB(String B) {
		this.B = B;
	}
	@Override
	public String toString(){
		return this.getUsername()+this.getA()+this.getB()+"C:"+this.getC()+"D:"+this.getD()+"E:"+this.getE()+"F:"+this.getF()+"G:"+this.getG()+"H:"+this.getH()+"I:"+this.getI()+"G:"+this.getG()+"K:"+this.getK()+"L:"+this.getL()+"M:"+this.getM()+"N:"+this.getN()+"O:"+this.getO()+"P:"+this.getP()+"Q:"+this.getQ()+"R:"+this.getR()+"S:"+this.getS()+"T:"+this.getT()+"U:"+this.getU()+"V:"+this.getV()+"W:"+this.getW()+"X:"+this.getX()+"Y:"+this.getY()+"Z:"+this.getZ()+"AA:"+this.getAA()+this.getAB();
	}
}
