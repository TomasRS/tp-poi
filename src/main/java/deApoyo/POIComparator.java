package deApoyo;

import org.uqbar.geodds.Point;

import pois.Direccion;
import pois.POI;

public class POIComparator {
	public static boolean mismoPOI(POI unPOI, POI otroPOI){
		boolean mismaCoordenada = mismoPunto(unPOI.getCoordenada(), otroPOI.getCoordenada());
		boolean mismaDireccion = mismaDireccion(unPOI.getDireccion(),otroPOI.getDireccion());
		boolean mismoNombre = unPOI.getNombre().equalsIgnoreCase(otroPOI.getNombre());
		boolean mismoRadioCercania = mismoNumero(unPOI.getRadioCercania(), otroPOI.getRadioCercania());
		boolean mismoRubro = unPOI.getRubro().equalsIgnoreCase(otroPOI.getRubro());
		boolean mismosTags = unPOI.getTags().containsAll(otroPOI.getTags())||(unPOI.getTags().size()==otroPOI.getTags().size());
		return mismaCoordenada && mismaDireccion && mismoNombre && 
				mismoRadioCercania && mismoRubro && mismosTags; 
	}
	
	public static boolean mismoPunto(Point unPunto, Point otroPunto){
		Double la1, la2, lo1, lo2;
		boolean mismaCoordenada;
		if (unPunto==null && otroPunto==null){
			mismaCoordenada = true;
		} else if (unPunto!=null && otroPunto!=null) {
			la1 = unPunto.latitude();
			la2 = otroPunto.latitude();
			lo1 = unPunto.longitude();
			lo2 = otroPunto.longitude();
//			mismaCoordenada = (la1-la2==0) &&
//					(lo1-lo2==0);
			mismaCoordenada = (la1.longValue()==la2.longValue()) && (lo1.longValue()==lo2.longValue());
		} else {
			mismaCoordenada = false;
		}
		return mismaCoordenada;
	}
	
	public static boolean mismaDireccion(Direccion unaDireccion, Direccion otraDireccion){
		boolean mismoBarrio = mismoString(
				unaDireccion.getBarrio(), otraDireccion.getBarrio());;
		boolean mismaCalle1 = mismoString(
				unaDireccion.getCalle1(), otraDireccion.getCalle1());;
		boolean mismaCalle2 = mismoString(
				unaDireccion.getCalle2(), otraDireccion.getCalle2());;
		boolean mismaCallePrincipal = mismoString(
				unaDireccion.getCallePrincipal(), otraDireccion.getCallePrincipal());
		boolean mismaLetraDepto = mismoString(
				unaDireccion.getLetraDepto(), otraDireccion.getLetraDepto());;
		boolean mismaLocalidad = mismoString(
				unaDireccion.getLocalidad(), otraDireccion.getLocalidad());;
		boolean mismoNumero = mismoNumero(unaDireccion.getNumero(),otraDireccion.getNumero());
		boolean mismoPiso = (unaDireccion.getPiso()==otraDireccion.getPiso());
		boolean mismoPais = mismoString(
				unaDireccion.getPais(), otraDireccion.getPais());;
		boolean mismaProvincia = mismoString(
				unaDireccion.getProvincia(), otraDireccion.getProvincia());;
		boolean mismaUnidad = mismoString(
				unaDireccion.getUnidad(), otraDireccion.getUnidad());;
		boolean mismaDireccion = mismaCalle1&&mismaCalle2&&mismaCallePrincipal&&mismaLetraDepto&&mismaLocalidad&&
				mismaProvincia&&mismaUnidad&&mismoBarrio&&mismoNumero&&mismoNumero&&mismoPais&&mismoPiso;
		return mismaDireccion;
	}
	
	public static boolean mismoString(String unString, String otroString){
		boolean sonIguales;
		if (unString==null && otroString==null){
			sonIguales = true;
		} else if (unString!=null && otroString!=null){
			sonIguales = unString.equalsIgnoreCase(otroString);
		} else {
			sonIguales = false;
		}
		return sonIguales;
	}
	
	public static boolean mismoNumero(Number unNumero, Number otroNumero){
		boolean sonIguales;
		if (unNumero==null && otroNumero==null){
			sonIguales = true;
		} else if (unNumero!=null && otroNumero!=null){
			sonIguales = mismoString(unNumero.toString(), otroNumero.toString());
		} else {
			sonIguales = false;
		}
		return sonIguales;
	}
	
}
