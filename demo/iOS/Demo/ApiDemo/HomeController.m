//
//  HomeController.m
//  JivoSupport
//
//  Created by Dimmetrius on 17.02.16.
//  Copyright © 2016 JivoSite. All rights reserved.
//

#import "HomeController.h"

@interface HomeController ()
- (IBAction)onSdkClick:(UIButton *)sender;
@property (weak, nonatomic) IBOutlet UIButton *startChat;

@end


@implementation HomeController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)viewWillAppear:(BOOL)animated{
    [self.navigationController setNavigationBarHidden:YES animated:animated];
    [super viewWillAppear:animated];
}

- (void)viewWillDisappear:(BOOL)animated {
    [super viewWillDisappear:animated];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)onSdkClick:(UIButton *)sender {
    [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"http://www.jivosite.ru/sdk"]];
}
@end
