package global 
{
	/**
	 * ...
	 * @author ...
	 */
	public class GlobalString
	{
		// LookUp
		public static const SEPARATOR:String = "-----------------------------------------";
		public static const SEARCHING:String = "正在查询...";
		public static const NORESULTS:String = "没有找到结果";
		public static const SEARCHMORE:String = "查询更多";
		public static const ERROR:String = "错误。请检查SPARQL语句的结构。";
		
		// Status Model
		public static const STATUS:String = "状态";
		public static const IDLE:String = "空闲";
		public static const NOCONNECTION:String = "数据库不可用。请查看网络连接.";
		public static const SOMEERRORS:String = "发生错误.";
		public static const NORELATION:String = "没有找到关系";
		public static const SEARCHINGRELATION:String = "正在查找关系";
		public static const LOOKUP:String = "正在查找资源";
		public static const BUILDING:String = "正在构建图";
		
		// Error Log
		public static const FINE:String = "一切正常。没有错误";
		
		public static function getStrings():Array {
			var strings:Array = new Array();
			strings.push(SEPARATOR);
			strings.push(SEARCHING);
			strings.push(NORESULTS);
			strings.push(SEARCHMORE);
			strings.push(ERROR);
			return strings;
		}
		
	}

}