var Browser = require('zombie'),
    expect = require('expect.js'),
    urlHome = 'http://127.0.0.1:3000',
    browser = new Browser();

browser.visit(urlHome, {debug: false}, function (err, browser) {
    expect(browser.success).to.be.ok();
    expect(browser.text('title')).to.be('Yawyl - You are what you listen');

    browser.clickLink('Search', function () {
        expect(browser.text('h2')).to.be('Search for Music');
        browser.fill('title', 'melody');
        browser.fill('artist_name', 'julien');
        browser.pressButton('Search', function () {
            expect(browser.text('#nbResults')).to.be('1');
            expect(browser.text('.page-wrapper')).to.be('page 1');
            expect(browser.queryAll('#results li')).to.have.length(1);
            expect(browser.text('#results li:first-child .song-title')).to.be('This Melody (Live)');
            console.log('PASS One result found');

            browser.fire('click', browser.query('#results li:first-child'), function () {
                expect(browser.text('h2')).to.be('Song Details');
                expect(browser.text('.details')).to.contain('Title : This Melody (Live)');
                expect(browser.text('.details')).to.contain('Artist : Julien Clerc');
                expect(browser.text('.details')).to.contain('Duration : 4 min 33 s');
                expect(browser.text('.details')).to.contain('Artist location : FR');
                console.log('PASS Details about Julien Clerc, This Melody (Live)');
            });
        });
    });
});