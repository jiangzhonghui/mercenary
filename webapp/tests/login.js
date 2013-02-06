var Browser = require('zombie'),
    expect = require('expect.js'),
    urlHome = 'http://127.0.0.1:3000',
    browser = new Browser();

browser.visit(urlHome, {debug: false}, function (err, browser) {
    expect(browser.success).to.be.ok();

    expect(browser.text('#login .name')).to.be('');
    expect(browser.query('#login .out')).to.be(undefined);
    expect(browser.query('#login .in')).not.to.be(undefined);
    browser.fill('name', '');
    expect(browser.query('#login .out')).to.be(undefined);
    expect(browser.query('#login .in')).not.to.be(undefined);
    console.log('PASS Form not sent when no name');

    browser.fill('name', 'Karim');
    browser.pressButton('#login .in', function () {
        expect(browser.text('#login .name')).to.be('Karim');
        expect(browser.query('#login .out')).not.to.be(undefined);
        expect(browser.query('#login .in')).to.be(undefined);
        console.log('PASS Username displayed');

        browser.pressButton('#login .out', function () {
            expect(browser.text('#login .name')).to.be('');
            expect(browser.query('#login .out')).to.be(undefined);
            expect(browser.query('#login .in')).not.to.be(undefined);
            console.log('PASS User logged out');
        });
    });
});