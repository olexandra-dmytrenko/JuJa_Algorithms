package regexp;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by Oleksandra_Dmytrenko on 06/02/2018.
 */
public class SplittingTest {
 private String realTextWithComas = "Other contract activity undertaken included: · Facilities management and support services at the ~~~Chevron~~~-operated Barrow Island assets, in WA; · Maintenance and major shutdown services at the Woodside-operated Karratha Gas Plant at Karratha, in WA; · Shutdown and maintenance services for ~~~Rio Tinto~~~'s coastal and inland operations in the Pilbara, WA; · Maintenance and shutdown services for BHP Billiton's Nickel West operations in the Goldfields, WA; · Maintenance and dragline shutdown works for BM Alliance Coal Operations in Queensland; · Capital works";
   private String Doc_64 =     "<Document><Title>Microsoft Word - ASX_MediaRelease_Half year to 31 Dec 2016 FINAL.doc</Title><Author>kglasgow</Author><TableCount>0</TableCount><Date>2017-02-20 18:26:50.000</Date><Body>\r\n21 February 2017\r\n\r\nMONADELPHOUS REPORTS HY 2017 REVENUE AND EARNINGS\r\n\r\nPerformance Highlights\r\nStrengthened position in Infrastructure market\r\nMaintenance services expanded\r\nNew Minerals EPC business established\r\nSales revenue $630.7 million*, in line with guidance provided\r\nNet profit after tax (NPAT) attributable to equity holders of the parent $28.6 million, similar to\r\npreceding six month period\r\nEarnings per share (EPS) 30.5 cents\r\nInterim Dividend 24 cps fully franked\r\nAwarded new contracts of approximately $700 million\r\nRecord net cash of $226.2 million, cash conversion of 172%\r\n\r\nEngineering company Monadelphous Group Ltd (ASX: MND) today announced its results for the half year\r\nended 31 December 2016.\r\n\r\nSales revenue for the period was $630.7 million*, similar to that of the preceding six months and in line with\r\nguidance provided, but down 14.4 per cent on the previous corresponding period. The result reflected lower\r\nconstruction activity levels, which were partially offset by rising Maintenance and Industrial Services revenues.\r\n\r\nNet profit after tax (NPAT) attributable to equity holders of the parent was $28.6 million, similar to that of the\r\npreceding six months, but down 24.1 per cent on the previous corresponding period.\r\n\r\nNew contracts valued at $700 million were awarded since the beginning of the period. Monadelphous\r\nManaging Director Rob Velletri said a significant portion of these contracts was for customers in the\r\ninfrastructure sector.\r\n\r\n“The award of additional water infrastructure and irrigation contracts together with the award of our first major\r\nrenewable energy project, highlights the success of our expansion into the infrastructure services sector,” Mr\r\nVelletri said.\r\n\r\nMonadelphous ended the period with a record net cash position of $226.2 million, and a healthy cash\r\nconversion rate of 172 per cent.\r\n\r\nA number of milestones were achieved in Monadelphous' market and growth strategy, with the expansion of\r\nthe Company's service offering in core maintenance markets and the establishment of two new strategic\r\nventures. Zenviron will provide EPC services to the renewable energy market in Australia and New Zealand,\r\nand Mondium, a partnership between Monadelphous and engineering and project management consultancy\r\nLycopodium, will offer turnkey EPC solutions to mining and minerals customers in Australia and overseas.\r\n\r\nMr Velletri said Monadelphous is in a solid position for long term growth, with a strong balance sheet providing\r\nit with substantial capacity to invest in new businesses, and a clear pipeline of opportunities in existing and new\r\nmarkets.\r\n\r\n“We have demonstrated our agility in responding to the downturn in the resources sector by successfully\r\ncapitalising on our strong position in the maintenance services sector and entering a number of new domestic\r\nand international markets” Mr Velletri said.\r\n\r\n “We will continue to work with our customers to maximise productivity within their operations to ensure we\r\ncontinue to deliver cost competitive solutions.”\r\n\r\nSafety will remain paramount, particularly as Monadelphous expands and diversifies.\r\n\r\n* Includes Monadelphous' share of joint venture revenue – refer to page 7 for reconciliation\r\n\r\n\r\n\r\nPage 1\r\n2017 HALF YEAR RESULTS\r\n\r\nRevenue\r\n\r\nMonadelphous recorded sales revenue of $630.7 million*, similar to that of the preceding six month period and\r\nin line with guidance provided. The result, which was 14.4 per cent down on the previous corresponding period,\r\nreflected lower construction activity levels, which were partially offset by rising Maintenance and Industrial\r\nServices revenues, highlighting the continuing transition in the resources and energy sectors from the\r\ninvestment phase to the production phase.\r\n\r\nEarnings\r\n\r\nNet profit after tax (NPAT) attributable to equity holders of the parent was $28.6 million, similar to that of the\r\npreceding six month period, but down 24.1 per cent compared to the previous corresponding period.\r\n\r\nEarnings before interest, tax, depreciation and amortisation (EBITDA)^ was $50.5 million, a decrease of 19.5\r\nper cent. Customer cost reduction programmes, reduced construction activity levels and an increasingly\r\ncompetitive environment continued to put pressure on margins.\r\n\r\nEarnings per share (EPS) was 30.5 cents.\r\n\r\nDividend\r\n\r\nThe Board of Directors has declared an interim dividend of 24.0 cents per share fully franked. The\r\nMonadelphous Group Limited Dividend Reinvestment Plan will apply to the interim dividend.\r\n\r\nStrong balance sheet\r\n\r\nMonadelphous' balance sheet ended the period in a strong position and the Company continues to maintain a\r\nhealthy working capital balance, with a record net cash of $226.2 million at 31 December 2016. The resolution\r\nof a number of outstanding claims during the period, including the agreement reached on the Wiggins Island\r\nCoal Export Terminal Project, contributed to a cash conversion rate of 172 per cent.\r\n\r\nSecured $700 million in new work\r\n\r\nNew contracts valued at approximately $700 million have been secured since the beginning of the financial\r\nyear, with a significant proportion for customers in the infrastructure sector.\r\n\r\nMonadelphous' existing Network and Facility Renewals Program contract with Sydney Water Corporation was\r\nexpanded to include the provision of mechanical, electrical and civil services. The award reinforced the\r\nCompany's relationship with Sydney Water and underlined its capability in the delivery of critical water and\r\nwaste water infrastructure.\r\n\r\nThe Company's newly established renewable energy business Zenviron, in consortium with wind turbine\r\nmanufacturer Vestas, was awarded a contract for the delivery of the Sapphire Wind Farm project in New South\r\nWales. The contract award represents a significant strategic milestone for the business and puts Zenviron in a\r\nstrong position to take advantage of the rapidly growing renewable energy sector in Australia and New\r\nZealand.\r\n\r\nSubsequent to the half year end, Monadelphous announced it had received a letter of intent to award a major\r\nfive year contract, in joint venture with Jacobs, for engineering, procurement and construction (EPC) services\r\non Oil Search Limited's oil and gas production facilities in Papua New Guinea. The partnership, which\r\ncombines Monadelphous' in-field services expertise with Jacobs' technical engineering capability, will lead to\r\nproductivity enhancements and cost savings for Oil Search. The contract builds on Monadelphous' decade-long\r\nrelationship with Oil Search, having provided brownfield project and maintenance services since 2007.\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n* Includes Monadelphous' share of joint venture revenue – refer to page 7 for reconciliation\r\n^ Refer to page 7 for reconciliation of EBITDA\r\n\r\nPage 2\r\nProductivity\r\n\r\nMonadelphous remains focused on maximising productivity, reducing costs and maintaining financial discipline.\r\n\r\nThe Company continues to work closely with its customers to deliver productivity improvements within their\r\noperations. Emphasis has been placed on identifying opportunities to improve productivity through innovation,\r\ntechnology and an ongoing business improvement drive. A number of technology solutions have been\r\ndeveloped to increase productivity levels across the business, including a new resource management system,\r\na workforce optimisation platform, robotic welding technology and automated 3D workpack development.\r\n\r\nDivisional and corporate support services have been further rationalised and the Company is driving\r\nstandardisation wherever possible to ensure lean and efficient support service delivery. In order to effectively\r\nsupport an increasingly global operational presence, focus has been placed on expanding business and project\r\nrelated services delivered from overseas locations.\r\n\r\nStrategic Progress\r\n\r\nDuring the period, Monadelphous made good progress in its markets and growth strategy.\r\n\r\nThe Maintenance and Industrial Services Division continued to expand the range of services provided in its\r\ncore markets, adding rope access capability and establishing a dewatering and industrial pipeline business.\r\nThe division also completed the acquisition of Arc West, an integrated services provider specialising in\r\ncorrosion management and protective coatings, based in Western Australia (WA).\r\n\r\nAnother key milestone in its growth and diversification strategy was the establishment of strategic joint venture,\r\nMondium. Mondium is a partnership between Monadelphous and engineering and project management\r\nconsultancy Lycopodium. It will provide turnkey EPC solutions to customers in the mining and mineral\r\nprocessing market both in Australia and overseas, and combines the respective strengths, complimentary\r\nexpertise and existing relationships of both companies. Mondium is currently pursuing a number of tender\r\nopportunities.\r\n\r\nDuring the period, the Company announced the formation of a new business focused on the growing renewable\r\nenergy market. Zenviron, a full service balance of plant contractor providing EPC services in Australia and New\r\nZealand, has already commenced operations and is currently pursuing a significant number of tender\r\nopportunities to construct wind and solar projects.\r\n\r\nThe award of additional water infrastructure and irrigation contracts reinforces the Company's infrastructure\r\nservice expansion, and there are a number of opportunities for further work in this market, particularly in New\r\nZealand and on the East Coast of Australia.\r\n\r\nThe Company continues to develop its position overseas, in both the growing oil and gas market in North\r\nAmerica and through its presence in Mongolia, where it is targeting work on Rio Tinto's multibillion dollar\r\nexpansion of the Oyu Tolgoi project. SinoStruct, the Company's China based fabrication business, has\r\nidentified a number of promising opportunities in the US market.\r\n\r\nOPERATIONAL OVERVIEW\r\n\r\nMarkets\r\n\r\nMonadelphous provides construction, maintenance and industrial services to the resources, energy and\r\ninfrastructure markets.\r\n\r\nThe resource and energy markets in Australia remain challenging, despite a recent improvement in commodity\r\nprices. Capital expenditure levels remain at historically low levels, as the rate of major investment in new\r\nproduction slows. The market continues to invest in sustaining capital works expenditure required to support\r\nthe significant increases in production levels.\r\n\r\nThe outlook for the maintenance sector remains positive as production levels grow and operating assets\r\nincrease in age.\r\n\r\nOpportunities in the broader infrastructure market are expected to grow, particularly in the renewable energy\r\nand transport infrastructure sectors, and Monadelphous' position in the water sector continues to strengthen.\r\n\r\n\r\n\r\n\r\n\r\nPage 3\r\nHealth and Safety\r\n\r\nThe total case injury frequency rate (TCIFR) was 3.43 incidents per million man-hours, and the lost time injury\r\nfrequency rate (LTIFR) was 0.09 incidents per million man-hours, with only one lost time incident recorded in\r\nthe six months.\r\n\r\nThe Company remains committed to maintaining its goal of an injury-free workplace, and will look to evolve and\r\nadapt its safety initiatives as it expands and diversifies into new services and markets.\r\n\r\nPeople\r\n\r\nThe Company's total workforce at 31 December 2016 was 4,989, an increase of 12 per cent from six months\r\nearlier. The growth in employee numbers reflected the increasing activity levels within the maintenance\r\nservices business.\r\n\r\nLabour productivity continues to strengthen, primarily as a result of improved labour availability amid reduced\r\ndemand, and lower unit costs. The Company continues to experience strong levels of key talent retention and a\r\nlower trend in permanent staff turnover.\r\n\r\nOPERATIONAL ACTIVITY\r\n\r\nEngineering Construction\r\n\r\nThe Engineering Construction division, which provides large-scale, multidisciplinary project management and\r\nconstruction services, reported sales revenue of $292.6 million* for the period.\r\n\r\nWorks continued at the Inpex-led Ichthys Project Onshore LNG Facility in Darwin, Northern Territory (NT). The\r\nCompany continues to perform strongly on this contract, and is expected to complete the scope of works under\r\nthe original contract by the end of the financial year. Monadelphous was awarded an additional package of\r\nelectrical and instrumentation works for the product loading jetty during the period and is well placed to secure\r\nany additional work that may arise on the project.\r\n\r\nThe Company's Infrastructure business continues to go from strength-to-strength. The water infrastructure\r\nbusiness recorded solid growth and has completed a number of New Zealand based irrigation projects. During\r\nthe period, the Company was awarded the design and construction of a major upgrade to Unitywater's Kawana\r\nSewage Treatment Plant in Queensland.\r\n\r\nSinoStruct recorded strong growth, securing some early work in the US as a result of the success of an\r\nextensive business development drive.\r\n\r\nRecent contract awards in the resources and energy sector include a structural, mechanical and piping\r\npackage associated with Newcrest's gold processing plant at its Cadia Valley operations, in NSW, the supply\r\nand fabrication of wellhead skids for Santos as part of its upstream CSG development in Northern Queensland\r\nand an order from APLNG, under an existing agreement, for the supply of additional wellhead skids. The\r\ndivision remains focused on new markets and overseas opportunities particularly in New Zealand and the US.\r\nDuring the period, other contract activity included:\r\n\r\n·     Structural, mechanical and piping works for Nyrstar at its Port Pirie Smelter in South Australia (SA);\r\n\r\n·     Electrical and instrumentation works for the product loading jetty with JKC Australia LNG at the Ichthys\r\n       Project Onshore LNG Facilities in Darwin, NT;\r\n\r\n·     Design, construction and commissioning of a liquid fuel supply system for Rio Tinto Iron Ore at its Cape\r\n       Lambert Port Facility near Karratha, in WA;\r\n\r\n·     Fabrication and supply of wellhead separator skids for APLNG in the Surat Basin, Queensland;\r\n\r\n·     Design and construction of a potable water treatment plant for the Western Downs Regional Council in\r\n       Chinchilla, Queensland; and\r\n\r\n       ·     Construction of a 130 kilometre water pipeline network associated with the Amuri irrigation scheme,\r\n               north of Christchurch, in New Zealand.\r\n\r\n* Includes share of joint venture revenue\r\n\r\n\r\n\r\n\r\nPage 4\r\nMaintenance and Industrial Services\r\n\r\nThe Maintenance and Industrial Services division, which specialises in the planning, management and\r\nexecution of multidisciplinary maintenance services, sustaining capital works and turnarounds, recorded sales\r\nrevenue of $339.6 million, which was 19 per cent higher than the second half of the 2016 financial year. The\r\nresult reflected the increased levels of maintenance and support activity for customers in the resources and\r\nonshore oil and gas sectors.\r\n\r\nThe division achieved high levels of contract retention in a very competitive environment. It continued its focus\r\non productivity improvement, working with customers to reduce costs and implement innovative solutions.\r\n\r\nSince the beginning of the financial year, Monadelphous has been awarded approximately $300 million in new\r\ncontracts, including a new five-year contract for BHP Billiton's Olympic Dam operation at Roxby Downs, SA.\r\n\r\nSubsequent to the period, the division received a letter of intent to award a five year contract, in joint venture\r\nwith Jacobs, to provide EPC services at Oil Search's oil and gas production facilities in Papua New Guinea.\r\n\r\nOther contract activity undertaken included:\r\n\r\n·     Facilities management and support services at the Chevron-operated Barrow Island assets, in WA;\r\n\r\n·     Maintenance and major shutdown services at the Woodside-operated Karratha Gas Plant at Karratha,\r\n       in WA;\r\n\r\n·     Shutdown and maintenance services for Rio Tinto's coastal and inland operations in the Pilbara, WA;\r\n\r\n·     Maintenance and shutdown services for BHP Billiton's Nickel West operations in the Goldfields, WA;\r\n\r\n·     Maintenance and dragline shutdown works for BM Alliance Coal Operations in Queensland;\r\n\r\n·     Capital works and maintenance events for BP at its Kwinana Refinery, in WA;\r\n\r\n·     Early works and modification services associated with Shell Australia's Prelude Floating Liquefied\r\n       Natural Gas (FLNG) project, in Darwin, NT;\r\n\r\n·     Multi-disciplinary services to the Woodside-operated Karratha Gas Plant Life Extension Program,\r\n       through MGJV, at Karratha, in WA and\r\n\r\n·     Project fieldwork services for Oil Search Limited at its oil and gas production and support facilities in\r\n       Papua New Guinea.\r\n\r\nOutlook\r\n\r\nMarket conditions in the Australian resources and energy sector continue to be challenging though the market\r\nenvironment is stabilising. Solid levels of capital expenditure required to sustain the massive increases in\r\nproduction levels are expected to provide construction opportunities, particularly in iron ore and upstream coal\r\nseam gas.\r\n\r\nProspects for maintenance services are positive as new LNG projects are commissioned and production ramps\r\nup. The aging of assets in the resources sector will also drive higher volumes of maintenance and support\r\nservices. The Company is well placed to capitalise on a number of new maintenance opportunities and grow its\r\nrecurring revenue base.\r\n\r\nMonadelphous will continue to pursue opportunities in infrastructure markets to further diversify revenues. In\r\nparticular it will strengthen its position in water infrastructure and renewable energy, with a number of new\r\ncontracts expected to be secured in the coming months.\r\n\r\nWhile the Company continues to experience some delays in the timing of awards and execution of committed\r\nworks, business activity levels have stabilised and at this stage we anticipate revenue for the second half of the\r\nfinancial year to be similar to that of the first half.\r\n\r\nProductivity improvements and the delivery of cost competitive solutions for customers will continue to be a key\r\nfocus area. High levels of competition and a focus on cost reduction by customers are likely to keep margins\r\nunder pressure.\r\n\r\n\r\n\r\n\r\nPage 5\r\nIn summary, Monadelphous is in good shape. It remains in a leadership position in its core markets and is\r\nmaking good progress to diversify its business into new services and new customer markets, both domestically\r\nand internationally.\r\n\r\nImportantly, a strong balance sheet provides it with substantial capacity to invest in new business opportunities,\r\nparticularly in the infrastructure sector where a number of potential acquisition opportunities are progressing\r\ntowards an advanced stage.\r\n\r\nI would like to take this opportunity to thank all our stakeholders for their loyalty and support, and particularly\r\nour people for their ongoing dedication, commitment and highly valued contribution.\r\n\r\n\r\n\r\nDIVIDEND ENTITLEMENTS\r\n\r\nThe interim dividend of 24 cents per share fully franked will be paid to shareholders on 31 March 2017 with the\r\nrecord date for entitlements being 10 March 2017.\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nPage 6\r\n^EBITDA is a non-IFRS earnings measure which does not have any standardised meaning prescribed by IFRS\r\nand therefore may not be comparable to EBITDA presented by other companies. This measure is important to\r\nmanagement when used as an additional means to evaluate the Company's profitability.\r\n\r\nReconciliation of Profit before tax to EBITDA (unreviewed)\r\n\r\n31 December        31 December\r\n2016                         2015\r\n$'000                        $'000\r\n\r\nProfit before tax                                                                               42,362                     53,188\r\nInterest expense                                                                                   411                           548\r\nInterest received                                                                              (1,924)                     (2,021)\r\nDepreciation expense                                                                      9,379                     10,961\r\nAmortisation expense                                                                          187                             65\r\nShare of interest, depreciation and amortisation\r\nof joint ventures #                                                                                   89                                -\r\nEBITDA                                                                                             50,504                     62,741\r\n\r\n# Represents Monadelphous' proportionate share of the interest, depreciation and amortisation of joint ventures\r\naccounted for using the equity method.\r\n\r\n\r\nReconciliation of Statutory Sales Revenue\r\n\r\n31 December        31 December\r\n2016                         2015\r\n$'000                        $'000\r\n\r\nTotal sales revenue including joint ventures                           630,736                   737,043\r\nShare of revenue from joint ventures ~                                       (5,542)                               -\r\nStatutory sales revenue                                                              625,194                   737,043\r\n\r\n\r\n~ Represents Monadelphous' proportionate share of the revenue of joint ventures accounted for using the\r\nequity method.\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nPage 7\r\nFURTHER INFORMATION\r\n\r\nAnalysts/Investors\r\n\r\nKristy Glasgow\r\nInvestor Relations\r\nT: +61 8 9316 6386\r\nM: +61 403 781 909\r\nEmail: investor_relations@monadel.com.au\r\n\r\n\r\n\r\n\r\n\r\nAbout Monadelphous\r\n\r\nMedia\r\n\r\nZoey Tyson\r\nMarketing and Communications Advisor\r\nT: +61 8 6311 1018\r\nM: +61 406 543 989\r\nEmail: ZTyson@monadel.com.au\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nMonadelphous Group Limited (ASX: MND) is a leading Australian engineering group providing construction,\r\nmaintenance and industrial services to the resources, energy and infrastructure sectors. The Company has two\r\noperating divisions - Engineering Construction, providing large-scale multidisciplinary project management and\r\nconstruction services, and Maintenance and Industrial Services, specialising in the planning, management and\r\nexecution of mechanical and electrical maintenance services, shutdowns, fixed plant maintenance services and\r\nsustaining capital works.\r\n\r\nMonadelphous is headquartered in Perth, Western Australia, with a major office in Brisbane, Queensland, and\r\nprojects, facilities and workshops across Australia and in New Zealand, China and Papua New Guinea. Please\r\nvisit our website for more information.\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nPage 8</Body></Document>";

    @Test
    public void splitter() throws Exception {
        String body = "This company is associated with:\r" +
                "- New Company," +
                "- Old Company." +
                "We're happy to announce " +
                "new way of thinking.\r\n" +
                "Now double break.\r\n\r\n" +
                "Let's test new line\n" +
                "Let's test dot coma;" +
                "It will be today.";
        String[] splitter = Splitting.splitter(body);
        System.out.println(splitter.length);
    }

    @Test
    public void splitterList() throws Exception {
        String body = realTextWithComas;
        String[] splitter = Splitting.splitter(body);
        System.out.println(splitter.length);
    }
    @Test
    public void splitter64() throws Exception {
        String body = Doc_64;
        String[] splitter = Splitting.splitter(body);
        IntStream.range(1, splitter.length).forEach( i -> System.out.println(i + ". " + splitter[i]));
        System.out.println(splitter.length);
    }
}