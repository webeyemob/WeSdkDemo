//
//  WeMobTrackerInfo.h
//  Created by Matthew on 2019/7/14.
//

#import <Foundation/Foundation.h>
#import "WeMobILineItem.h"

@interface WeMobTrackerInfo : NSObject

@property float eCPM;
@property int networkId;
@property NSString *lineItemAdUnitId;
@property NSString *adUnitId;
@property int adType;

- (WeMobTrackerInfo *)initWithLineItem:(WeMobILineItem *)lineItem;

@end
