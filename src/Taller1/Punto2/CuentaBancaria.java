package Taller1.Punto2;

public class CuentaBancaria {
	
	protected Float saldo;
	protected Integer numeroConsignaciones = 0;
	protected Integer numeroRetiros = 0;
	protected Float tasaAnual;
	protected Float comisionMensual = (float) 0;
	
	public CuentaBancaria(Float saldo, Float tasaAnual) {
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
	}

	protected void consignarCantidad(Float cantidadDinero){
		this.saldo += cantidadDinero;
	}

	protected void retirarCantidad(float cantidadDinero){
		if(cantidadDinero <= this.saldo){
			this.saldo -= cantidadDinero;
		}
	}

	protected void extractoMensual(){
		this.saldo -= this.comisionMensual + this.calularInteresMensual();
	}

	protected void aplicarInteresMensual(){
		this.saldo -= this.calularInteresMensual();
	}

	protected void imprimir(){
		System.out.println(this.toString());
	}

	private Float calularInteresMensual(){
		return this.saldo*(this.tasaAnual/12)/100;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Integer getNumeroConsignaciones() {
		return numeroConsignaciones;
	}

	public void setNumeroConsignaciones(Integer numeroConsignaciones) {
		this.numeroConsignaciones = numeroConsignaciones;
	}

	public Integer getNumeroRetiros() {
		return numeroRetiros;
	}

	public void setNumeroRetiros(Integer numeroRetiros) {
		this.numeroRetiros = numeroRetiros;
	}

	public Float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(Float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public Float getComisionMensual() {
		return comisionMensual;
	}

	public void setComisionMensual(Float comisionMensual) {
		this.comisionMensual = comisionMensual;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [saldo=" + saldo + ", numeroConsignaciones=" + numeroConsignaciones + ", numeroRetiros="
				+ numeroRetiros + ", tasaAnual=" + tasaAnual + ", comisionMensual=" + comisionMensual + "]";
	}

}
