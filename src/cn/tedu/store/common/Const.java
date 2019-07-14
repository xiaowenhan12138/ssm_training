package cn.tedu.store.common;

public final class Const {

	//通用状态
	public static final int PAGE_SIZE = 10;
	public static final int ERROR = -1;
	public static final int FAILED = 0;
	public static final int SUCCESS = 1;
	
	//订单付款状态 payment_status
	public static final int STATUS_TRANSACTION_INCOMPLETE = 0;	//交易未完成 - 此付款状态仅适用于在线付款，意味着客户尚未完成在线付款流程。
	public static final int STATUS_TRANSACTION_INCOMPLETE_CANCELLED_BY_SYSTEM = 1;	//交易不完整（由系统取消） - 此状态仅适用于在线交易。如果交易的初始状态为“未完成”，则交易将在一段时间后自动被系统取消，如果该交易在该时间段内尚未由客户完成。
	public static final int STATUS_AWAITING_PAYMENT = 2;	//订单的付款状态：等待付款 等待付款 - 此状态适用于在线和离线付款。在网上支付的情况下，这意味着实际交易尚未结清，可能需要额外时间才能结算。对于离线付款，等待状态意味着付款将在稍后的时间点进行。
	public static final int STATUS_PAYMENT_COMPLETED = 3;	//订单的付款状态：付款成功 付款已完成 - 此状态适用于在线和离线付款。在这两种情况下，这种状态意味着付款已经完成，并且这笔钱已经被店铺收到或即将收到。
	public static final int STATUS_PAYMENT_FAILED = 4;		//付款失败 - 此状态仅指在线付款。如果在处理付款过程中发生了某些问题，并且付款处理器无法处理付款，则在线付款可以自动收到失败状态。
	public static final int STATUS_PAYMENT_CANCELLED = 5;	//付款已取消 - 此状态适用于在线和离线付款。当通过使用关联的取消订单按钮取消订单时，付款状态也会变为取消。
	public static final int STATUS_PAYMENT_REFUNDED = 6;	//退款已付款 - 此状态适用于在线和离线付款。如果商店已经为相应的订单执行退款，则付款可以标记为退款。
	public static final String[] paymentStatusArray = {"交易未完成", "交易不完整（由系统取消）", "等待付款",
										"付款成功", "付款失败", "付款已取消", "退款已付款"};
	
	//订单发货状态常量 shipping_status 
	public static final int STATUS_AWAITING_ORDER = 0;		//等待处理订单，待处理（等待付款，付款成功）等待订单 - 每个新订单都将以等待装运状态进入系统。此状态表示需要店铺管理员进行额外输入，以便进一步处理订单或取消订单。
	public static final int STATUS_ORDER_IN_PROCESSING = 1;	//订单处理中，	  处理中 处理中的订单 - 此状态表示订单目前正在准备中，以便可以发货。
	public static final int STATUS_ORDER_DISPATCHED = 2;	//订单已经发送  已发货 订单已发货 - 此状态表示订单已从商店的仓库发出并正在交付过程中。
	public static final int STATUS_ORDER_DELIVERED = 3;		//订单已经交付  已交付 订单已交付（已收到） - 订单可在交货服务确认订单已交付并由客户收到后标记为已交付（已收到）。
	public static final int STATUS_ORDER_RETURNED = 4;		//订单已经退回  已退货 订单已退回 - 如果客户拒绝了订单并且订单已退回商店，订单可标记为已退回。
	public static final int STATUS_ORDER_CANCELED = 5;
	public static final String[] shippingStatusArray = {"待处理", "处理中", "已发货", "已交付", "已退货", "订单已取消"};
	
	public static String getPaymentStatusName(int paymentStatus) {
		return paymentStatusArray[paymentStatus];
	}
	public static String getShippingStatusName(int shippingStatus) {
		return shippingStatusArray[shippingStatus];
	}
}
